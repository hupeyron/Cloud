<?php
require 'vendor/autoload.php';

$client = new GuzzleHttp\Client(['base_uri'=>'https://cloud-350809.ew.r.appspot.com/approval']);
$approval = null;
try {
    echo "REQUEST /add :\n";
    $res = $client->get('/add', [GuzzleHttp\RequestOptions::JSON => ['nom' => 'Hugo']]);
    echo "Code retour : {$res->getStatusCode()}\n";
    $approvalId = json_decode($res->getBody(), true);
} catch (\GuzzleHttp\Exception\ClientException $e) {
    echo json_decode($e->getResponse()->getBody())->message."\n";
}
try {
    echo "\nREQUEST /getbyID :\n";
    $res = $client->post('/getbyID', [GuzzleHttp\RequestOptions::JSON => ['id' => $approvalId]]);
    echo "Code retour : {$res->getStatusCode()}\n";
    $approval = json_decode($res->getBody(), true);
    echo "Approval Id : {$approvalId}\n";

    echo "\nREQUEST /getall :\n";
    $res = $client->get('/getAll');
    echo "Code retour : {$res->getStatusCode()}\n";
    $array = json_decode($res->getBody(), true);
    $lastApproval = end($array);
    echo "Last Approval : ".print_r($lastApproval, true);
}catch(\GuzzleHttp\Exception\ClientException $e){
    echo json_decode($e->getResponse()->getBody())->message."\n";
}


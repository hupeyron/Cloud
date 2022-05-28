<?php
require 'vendor/autoload.php';

$client1 = new GuzzleHttp\Client(['base_uri'=>'https://cloud-350809.ew.r.appspot.com/loan']);
$client2 = new GuzzleHttp\Client(['base_uri'=>'https://cloud-350809.ew.r.appspot.com/account']);

try {
    echo "REQUEST /add :\n";
    $res = $client2->get('/add', [GuzzleHttp\RequestOptions::JSON => ['nom' => 'Nom2']]);
    echo "Code retour : {$res->getStatusCode()}\n";
    $accountId = json_decode($res->getBody(), true);

    echo "\nResuqest loan/demande\n";
    $res = $client1->post('/demande', [GuzzleHttp\RequestOptions::JSON => ['id' => $accountId, 'somme' => 11000]]);
    echo "Code retour : {$res->getStatusCode()}\n";
    $reponse = json_decode($res->getBody(), true);
    echo "reponse de la demande de prêt : {$reponse}\n";
}catch(\GuzzleHttp\Exception\ClientException $e){
    echo json_decode($e->getResponse()->getBody())->message."\n";
}


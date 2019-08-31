<?php
// Post isteği "mesajı" değişken olsun
// Bu Android uygulaması gelen veriler
$message=$_POST["message"];

// biz değişken mesaj içeriğini tutacak dosya belirtelim
$filename="androidmessages.html";

// dosyasına ardarda veri yazmak
file_put_contents($filename,$message."<br />",FILE_APPEND);

// bir değişken için dosyanın içeriğini yüklemek
$androidmessages=file_get_contents($filename);

// Dosyasının içeriğini bir değişkene atayıp yazdırıyoruz.
echo $androidmessages;
echo "GELEN : <br />".$message;
?>
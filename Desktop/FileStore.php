<?php 
 
       $imei   = urldecode($_POST['imei']);
       $service   = urldecode($_POST['service']);
       $model_make  = urldecode($_POST['model_make']);
       $os_version   = urldecode($_POST['os_version']);
        
       print " ==== POST DATA =====
       IMEI : $imei
       Service : $service
       Model Make  : $model_make
       Android Version  : $os_version"; 
 
 ?>
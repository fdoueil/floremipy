/**
 * 
 */
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "scripts/jsonp.php",
            //"url": "localhost",
            "dataType": "jsonp"
        }
    } );
} );
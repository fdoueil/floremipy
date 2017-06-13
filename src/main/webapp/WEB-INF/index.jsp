<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" charset="utf8" src="js/jquery-1.12.4.js"></script>

<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<link type="text/css" rel="stylesheet" href="css/main.css" />

<title>FloreMipy</title>

</head>
<body>

<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Ref</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Quantite</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Ref</th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Quantite</th>
            </tr>
        </tfoot>
    </table>
    
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

   <script type="text/javascript">
    $(document).ready(function() {
                $("#example").dataTable({
                	data: [["RefAA1",
                            "Palmier",
                            "29",
                            "100"
                           ],
                          
                          [
                             "RefAA2",
                             "Rosiers",
                             "9",
                             "200"
                          ],
                          
                          [
                              "RefAA3",
                              "Chrisanthème",
                              "19",
                              "50"
                          ],
                          
                          [
                              "RefAA4",
                              "Bananier",
                              "9",
                              "10"
                          ],
                          
                          [
                              "RefAA5",
                              "Olivier",
                              "599",
                              "100"
                          ],

                          [
                              "RefAA6DeBase",
                              "Gazon",
                              "1",
                              "1000000"
                          ]
                      ]
                });
              
    } );

    </script>
</body>
</html>



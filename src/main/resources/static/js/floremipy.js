/**
 * 
 */
//$(document).ready(function() {
//    $('#example').DataTable( {
//        "processing": true,
//        "serverSide": true,
//        "ajax": {
//            "url": "floremipyREST/catalogue",
//            "dataType": "jsonp"
//        }
//    } );
//} );
var dataSet=[["RefAA1",
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
];
$(document).ready(function() {
$(function(){
    $("#example").dataTable({
    	data: dataSet,
    	columns: [
    	            { title: "Ref" },
    	            { title: "Name" },
    	            { title: "Price" },
    	            { title: "Quantity" }
    	        ]
    });
  })
});
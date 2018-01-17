/* global post */
var VarHolder = {};
(function($) {
  "use strict"; // Start of use strict

  // Smooth scrolling using jQuery easing
  $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: (target.offset().top - 48)
        }, 1000, "easeInOutExpo");
        return false;
      }
    }
  });

  // Closes responsive menu when a scroll trigger link is clicked
  $('.js-scroll-trigger').click(function() {
    $('.navbar-collapse').collapse('hide');
  });

  // Activate scrollspy to add active class to navbar items on scroll
  $('body').scrollspy({
    target: '#mainNav',
    offset: 54
  });

  // Collapse Navbar
  var navbarCollapse = function() {
    if ($("#mainNav").offset().top > 100) {
      $("#mainNav").addClass("navbar-shrink");
    } else {
      $("#mainNav").removeClass("navbar-shrink");
    }
  };
  // Collapse now if page is not at top
  navbarCollapse();
  // Collapse the navbar when page is scrolled
  $(window).scroll(navbarCollapse);

})(jQuery); // End of use strict

// User custom scripts for ajax form submit



$("#hideModal").click(function (){
//    $("#mymodal").;
});

   $("#forLogin").click(function(e) {
       e.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();
        
     
    $.ajax({
        url : "Main",
        type : "post",
        data : {username: username,
                password: password,
                first: VarHolder.first,
                second: VarHolder.second,
                third: VarHolder.third
            },
        success : function(result){
//            window.location.reload();


            if (typeof result === "object"){
                var countL = result[0];
//                var countL2 = result[1];
//                var countL3 = result[2];
                var counted = result[1];
                var counted2 = result[2];
                var counted3 = result[3];
                
//                alert(counted);
                var list = $("#list");
                var $create = $('<ul>').addClass("list-group").appendTo(list);
//                $("<li>").text("List Item").appendTo($create);
                var hj = 14;
                var u = 29;
                $.each(countL, function(index, item){
                  var $jag = $("<li>").html(item).addClass("list-group-item lis").appendTo($create); 
                  hj++;
                  u++;
//                  console.log(hj);
                   $("<span>").html(counted[index]+" "+counted2[hj]+" "+counted3[u]).addClass("badge badge-info float-right").appendTo($jag);
                });
                $("#loginDiv").replaceWith("#list");
                $("#myModal").modal('hide');
                $("#disp").html("");
                $("#username").html("");
                $("#password").html("");
            
        } 
        else if(typeof result === "string"){
            $("#disp").html(result);
        }
             
        }
     });
     
   });
   
   $("#forLoginClear").click(function(){
      $("#disp").html(""); 
   });
   
   //*************************** Submit modal tweaking *****************************//
   
   $("#modal-pop").click(function(e){
       e.preventDefault();
       if ($("#first").val() === "-Select Option-"){
           
           $("#err-disp").html("Choose a language");
           $("#myModal").modal('hide');
   } else VarHolder.first = $("#first").val();
   if ($("#second").val() === "-Select Option-"){
           $("#err-disp").html("Choose a language");
   } else VarHolder.second = $("#second").val();
   if ($("#third").val() === "-Select Option-"){
           $("#err-disp").html("Choose a language");
   } else VarHolder.third = $("#third").val();
//       VarHolder.second = $("#second").val();
//       VarHolder.third = $("#third").val();
   });
   
   
   //********************Registration Ajax Call*********************//
   
   $("#forReg").click(function (){
       var firstname = $("#fname").val();
       var lastname = $("#lname").val();
       var usernameR = $("#usernameR").val();
       var passwordR = $("#passwordR").val();
       
       $.ajax({
           url: "Main",
           type: "post",
           data: {
               firstname: firstname,
               lastname: lastname,
               usernameR: usernameR,
               passwordR: passwordR
           },
           success: function(print){
               $("#dispR").html(print);
           }
       });
   });

$("#tes").click(function(){
    alert("Okay");
});

// Google Maps Scripts
//var map = null;
//// When the window has finished loading create our google map below
//google.maps.event.addDomListener(window, 'load', init);
//google.maps.event.addDomListener(window, 'resize', function() {
//  map.setCenter(new google.maps.LatLng(40.6700, -73.9400));
//});

function init() {
  // Basic options for a simple Google Map
  // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
  var mapOptions = {
    // How zoomed in you want the map to start at (always required)
    zoom: 15,

    // The latitude and longitude to center the map (always required)
    center: new google.maps.LatLng(40.6700, -73.9400), // New York

    // Disables the default Google Maps UI components
    disableDefaultUI: true,
    scrollwheel: false,
    draggable: false,

    // How you would like to style the map.
    // This is where you would paste any style found on Snazzy Maps.
    styles: [{
      "featureType": "water",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 17
      }]
    }, {
      "featureType": "landscape",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 20
      }]
    }, {
      "featureType": "road.highway",
      "elementType": "geometry.fill",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 17
      }]
    }, {
      "featureType": "road.highway",
      "elementType": "geometry.stroke",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 29
      }, {
        "weight": 0.2
      }]
    }, {
      "featureType": "road.arterial",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 18
      }]
    }, {
      "featureType": "road.local",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 16
      }]
    }, {
      "featureType": "poi",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 21
      }]
    }, {
      "elementType": "labels.text.stroke",
      "stylers": [{
        "visibility": "on"
      }, {
        "color": "#000000"
      }, {
        "lightness": 16
      }]
    }, {
      "elementType": "labels.text.fill",
      "stylers": [{
        "saturation": 36
      }, {
        "color": "#000000"
      }, {
        "lightness": 40
      }]
    }, {
      "elementType": "labels.icon",
      "stylers": [{
        "visibility": "off"
      }]
    }, {
      "featureType": "transit",
      "elementType": "geometry",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 19
      }]
    }, {
      "featureType": "administrative",
      "elementType": "geometry.fill",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 20
      }]
    }, {
      "featureType": "administrative",
      "elementType": "geometry.stroke",
      "stylers": [{
        "color": "#000000"
      }, {
        "lightness": 17
      }, {
        "weight": 1.2
      }]
    }]
  };

  // Get the HTML DOM element that will contain your map
  // We are using a div with id="map" seen below in the <body>
  var mapElement = document.getElementById('map');

  // Create the Google Map using out element and options defined above
  map = new google.maps.Map(mapElement, mapOptions);

  // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
  var image = 'img/map-marker.svg';
  var myLatLng = new google.maps.LatLng(40.6700, -73.9400);
  var beachMarker = new google.maps.Marker({
    position: myLatLng,
    map: map,
    icon: image
  });
}

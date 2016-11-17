(function () {

    'use strict';

    function initialize () {

        var center = new google.maps.LatLng(-26.979533, -48.636814),
            mapOptions = {
                center: center,
                zoom: 15,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

        var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

        var styles = [
            {
                featureType: "administrative.province",
                elementType: "labels.text",
                stylers:[
                    { visibility: "simplified" }
                ]
            },
            {
                featureType: "landscape.natural",
                elementType: "geometry.fill",
                stylers: [
                    { visibility: "on" },
                    { color:"#e0efef" }
                ]
            },
            {
                featureType: "poi",
                elementType: "geometry.fill",
                stylers: [
                    { visibility: "on" },
                    { hue: "#1900ff" },
                    { color: "#c0e8e8" }
                ]
            },
            {
                featureType: "road",
                elementType: "geometry",
                stylers: [
                    { lightness: 100 },
                    { visibility: "simplified" }
                ]
            },
            {
                featureType: "road",
                elementType: "labels",
                stylers: [
                    { visibility: "off" }
                ]
            },
            {
                featureType: "transit.line",
                elementType: "geometry",
                stylers: [
                    { visibility: "on" },
                    { lightness: 700 }
                ]
            },
            {
                featureType: "water",
                elementType: "all",
                stylers:[
                    { color: "#7dcdcd" }
                ]
            }
        ];

        var styledMap = new google.maps.StyledMapType(styles, { name: "Styled Map" });

        map.mapTypes.set('map_style', styledMap);
        map.setMapTypeId('map_style');

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var centerPos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                map.setCenter(centerPos);
            });
        }

        setMarkers(map);

    }

    function setMarkers (map) {

        var image = 'bus_icon.png';

        $.getJSON("http://busao-sisnetpi.rhcloud.com/api/position", function (json) {

            $.each(json, function (key, data) {

                var latLng = new google.maps.LatLng(
                    data.coordinates.latitude,
                    data.coordinates.longitude
                );

                // Creating a marker and putting it on the map
                var marker = new google.maps.Marker({
                    position: latLng,
                    icon: image,
                    title: data.deviceId
                });

                marker.setMap(map);

            });
        });

    }

    google.maps.event.addDomListener(window, 'load', initialize);

})();

var context = '/fsecure';

$(document).ready(function(){
    $('#map_canvas').css('height', '100%');
    $('#location_info').hide();
});

function initialize() {
    var myOptions = {
        center: new google.maps.LatLng(3.13638936333, 101.68556884765),
        zoom: 12,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
		
    google.maps.event.addListener(map, "click", function(event) {
        var lat = event.latLng.lat();
        var lng = event.latLng.lng();	
        getNearestLocation(lat, lng);
    });
}

/**
 * getNearestLocation
 */
function getNearestLocation(lat, lng) {
    $.ajax({
        url: context+"/location?x="+lng+"&y="+lat,
        dataType: 'html',
        processData: true,
        beforeSend: function(){
            $('#location_info').append("<img src='"+context+"/images/ajax-loader.gif'></img>");
            $('#location_info').show('medium');
        },
        success: function(data){
            $('#location_info').find('p').remove();
            html = "<p>" + data.toString() + "</p>";
            $('#location_info').append(html);
            
        },
        complete: function(){            
            $('#location_info').find('img').remove();
        },
        error: function(){
            $('#location_info').append("<label class='error'>Oops... server is busy, please try again later</label>");
        }
    });

}
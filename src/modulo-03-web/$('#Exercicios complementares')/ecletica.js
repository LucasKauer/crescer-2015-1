'use script';

$(function(){
	$('.button').click(function() {
			var search = $('input[name=search]').val();
			$.ajax({
				url: 'https://api.spotify.com/v1/search?q='+search+'&type=artist',
				type: 'GET'
			})
			.done(function(i) {
				var id = i.artists.items[0].id;
				
				$.ajax({
					url: 'https://api.spotify.com/v1/artists/'+id+'/albums?limit=50',
					type: 'GET'
				})
				.done(function(data) {
					data.items.forEach(function(i) {
						$('#NerverSayNever').append($("<img>")
							.attr("src", i.images[1].url))
					});
				});
			});
	});	
});
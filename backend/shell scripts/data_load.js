function randomString() { 
        var chars = 
"0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"; 
        var randomstring = ''; 
        var string_length = 6;
        for (var i=0; i<string_length; i++) { 
                var rnum = Math.floor(Math.random() * chars.length); 
                randomstring += chars.substring(rnum,rnum+1); 
        } 
        return randomstring; 
} 

db = connect("localhost:27017/movies");

for (i = 0; i < 100; i++) {
	db.collection.insertOne({
	"title"      : randomString(),
	"year"       : 2019,
	"genre"      : randomString(),
	"director"   : randomString(),
	"actors"     :[randomString(), randomString()],
	"rating"     : (100 - i)/100,
	"description": randomString()	
});  
}

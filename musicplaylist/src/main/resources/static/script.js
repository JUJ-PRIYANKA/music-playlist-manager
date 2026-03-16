const API = "/api";

function loadSongs(){

fetch(API + "/songs")
.then(res => res.json())
.then(data => {

let list = document.getElementById("songList");
list.innerHTML = "";

document.getElementById("songCount").innerText =
"Total Songs: " + data.length;

data.forEach(song => {

let li = document.createElement("li");

li.innerHTML =
song.songName + " - " + song.artist + " (" + song.duration + ") " +
`<button onclick="deleteSong(${song.id})">Delete</button>`;

list.appendChild(li);

});

});
}

function addSong(){

let songName = document.getElementById("songName").value;
let artist = document.getElementById("artist").value;
let duration = document.getElementById("duration").value;

// check empty fields
if(songName === "" || artist === "" || duration === ""){
alert("Please fill all fields");
return;
}

// validate duration format mm:ss
let pattern = /^[0-5][0-9]:[0-5][0-9]$/;

if(!pattern.test(duration)){
alert("Duration must be in mm:ss format (example: 03:45)");
return;
}

fetch("/api/add",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
songName:songName,
artist:artist,
duration:duration
})
})
.then(()=>{

loadSongs();

document.getElementById("songName").value="";
document.getElementById("artist").value="";
document.getElementById("duration").value="";

alert("Song added successfully!");

});

}

function deleteSong(id){

fetch(API + "/delete/" + id,{
method:"DELETE"
})
.then(()=>loadSongs());

}

function shufflePlaylist(){

fetch(API + "/shuffle")
.then(res => res.json())
.then(data => {

let list = document.getElementById("songList");
list.innerHTML = "";

data.forEach(song => {

let li = document.createElement("li");

li.innerHTML =
song.songName + " - " + song.artist + " (" + song.duration + ") " +
`<button onclick="deleteSong(${song.id})">Delete</button>`;

list.appendChild(li);

});

});
}

window.onload = loadSongs;
function searchSongs(){

let input = document.getElementById("searchBox").value.toLowerCase();

let songs = document.querySelectorAll("#songList li");

songs.forEach(song => {

let text = song.textContent.toLowerCase();

if(text.includes(input)){
song.style.display = "";
}else{
song.style.display = "none";
}

});

}
function sortSongs(){

let list = document.getElementById("songList");

let items = Array.from(list.getElementsByTagName("li"));

items.sort((a,b)=>{
return a.textContent.localeCompare(b.textContent);
});

list.innerHTML = "";

items.forEach(item=>{
list.appendChild(item);
});

}
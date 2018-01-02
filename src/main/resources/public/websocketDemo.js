

//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/chat")
webSocket.onmessage = function (msg) {
    console.log("Received message update!")
    update(msg)
}

//webSocket.onclose = function () { alert("WebSocket connection closed") }

$("#card1").click( function () {
    sendJson("1");
});
// document.getElementById("card1").addEventListener("click", function () {
//     alert("card1 is played!")
//     document.getElementById("card1").remove()
//     console.log("removed!")
//     sendJson("1")
// })

// document.getElementById("card2").addEventListener("click", function () {
//     alert("card2 is played!")
//     // document.getElementById("card2").remove()
// })

$("#card2").click( function () {
    sendJson("2");
});

$("#card3").click( function () {
    sendJson("3")
})

$("#card11").click(function () {
    sendJson("11")
})

$("#card22").click(function () {
    sendJson("22")
})

$("#card33").click(function () {
    sendJson("33")
})

// //Send message if enter is pressed in the input field
// id("message").addEventListener("keypress", function (e) {
//     if (e.keyCode === 13) { sendMessage(e.target.value); }
// });


function sendJson(string) {
    console.log("card" + string + " is played!")
    webSocket.send(JSON.stringify({play: string}))
    console.log("Message sent!")
    var card = "#card" + string
    $(card).remove()
}

function update(message) {
    $.ajax({
        url: "/testget/",
        type: "GET",
        data: {'input': message.data}
    })
        .done( function(data) {
            console.log("'GET' method success: " + data)
            var card = "#card" + JSON.parse(data).play
            $(card).remove()
    })
        .fail( function(data) {
            console.log("error: " + data)
        })
}


// //Update the chat-panel, and the list of connected users
// function updateChat(msg) {
//     var data = JSON.parse(msg.data);
//     insert("chat", data.userMessage);
//     id("userlist").innerHTML = "";
//     data.userlist.forEach(function (user) {
//         insert("userlist", "<li>" + user + "</li>");
//     });
// }

// //Helper function for inserting HTML as the first child of an element
// function insert(targetId, message) {
//     id(targetId).insertAdjacentHTML("afterbegin", message);
// }
//
// //Helper function for selecting element by id
// function id(id) {
//     return document.getElementById(id);
// }


//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/chat")

webSocket.onopen = function() {
    $("#hand2").addClass("disabledDiv");
}

webSocket.onmessage = function (msg) {
    console.log("Received message update!")
    update(msg)
}
// webSocket.onclose = function () { alert("玩家掉线，游戏结束") }

$("#card1").click( function () {
    sendJson("1");
});

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


function sendJson(string) {
    // Send the appropriate JSON
    switch (string.charAt(0)) {
        case "1":
            console.log("Attack is played!")
            webSocket.send(JSON.stringify({play: string, request: "attack", amount: 1}))
            break
        case "2":
            console.log("Dodge is played!")
            webSocket.send(JSON.stringify({play: string}))
            break
        default:
            console.log("Peach is played!")
    }

    // Remove the card
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
            var cardNo = JSON.parse(data).play
            $("#card" + cardNo).remove()
            if (cardNo.charAt(0) == "1") {
                alert("Your opponent played an Attack. Please play a dodge.")
                changeTurn()
            }
    })
        .fail( function(data) {
            console.log("error: " + data)
        })
}

function changeTurn() {
    if ($("#hand1").is(".disabledDiv")) {
        console.log("enter if")
        $("#hand1").removeClass("disabledDiv")
        $("#hand2").addClass("disabledDiv")
    } else {
        console.log("enter else")
        $("#hand2").removeClass("disabledDiv")
        $("#hand1").addClass("disabledDiv")
    }
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
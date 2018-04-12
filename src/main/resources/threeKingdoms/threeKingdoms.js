

//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/threeKingdoms")

webSocket.onopen = function() {
    $("#hand").addClass("tempDisabled")
};

webSocket.onmessage = function (msg) {
    console.log("Received message update! Message is: " + msg.data)
    var json = JSON.parse(msg.data)
    if (json.command == "draw") {
        startTurn(msg.data)
    } else {
        update(msg.data)
    }
}
// webSocket.onclose = function () { alert("玩家掉线，游戏结束") }

var hand = [];


$("#card1").click( function () {
    // if (checkActive(hand[0][0])) {
    //
    // }
    play(1)
});

$("#card2").click( function () {
    // sendJson("2");
    play(2)
});

$("#card3").click( function () {
    // sendJson("3")
    play(3)
})

$("#end").click( function () {
    wait()
    webSocket.send("end")
})



function sendJson(string) {
    // Send the appropriate JSON
    switch (string.charAt(0)) {
        case "1":
            console.log("Attack is played!")
            webSocket.send(JSON.stringify({play: string, request: "attack", amount: 1}))
            wait()
            break
        case "2":
            console.log("Dodge is played!")
            webSocket.send(JSON.stringify({play: string}))
            wait()
            break
        default:
            console.log("Peach is played!")
            webSocket.send(JSON.stringify({play: string}))
    }

    // Remove the card
    var card = "#card" + string
    console.log("You played a " + card + "!")
    $(card).remove()
}

function update(message) {
    $.ajax({
        url: "/update/",
        type: "GET",
        data: {input: message}
    })
        .done( function(data) {
            console.log("'UPDATE' method success: " + data)

            var cardNo = JSON.parse(data).play
            // $("#card" + cardNo).remove()
            if (cardNo.charAt(0) === "1") {
                alert("Your opponent played ATTACK. Please play a DODGE.")
                resume()
            }
            if (cardNo.charAt(0) === "1") {
                resume()
            }
        })
        .fail( function(data) {
            console.log("error: " + data)
        })
}


function startTurn(message) {
    console.log("enter startTurn")
    $.ajax({
        url: "/startTurn/",
        type: "GET",
        data: {input: message}
    })
        .done( function(data) {
            console.log("'START TURN' method success: " + data)
            // alert("It's your turn to play!")
            var cards = JSON.parse(data).cards
            cards.forEach(function (card) { hand.push(card) })
            updateHand()
            resume()
        })
        .fail( function(data) {
            console.log("error: " + data)
        })
    // console.log("'START TURN' method success: " + message)
    // var cards = JSON.parse(message).cards
    // cards.forEach(function (card) { hand.push(card) })
    // updateHand()
    // resume()

}

function updateHand() {
    for (var i = 0; i < hand.length; i++) {
        var type = hand[i][0]
        var card = "card" + (i + 1)
        document.getElementById(card).innerHTML = "<img src='pictures/" + type + ".jpg' />"
    }
}


function wait() {
    $("#hand").addClass("tempDisabled")
}

function resume() {
    alert("You can play a card")
    $("#hand").removeClass("tempDisabled")
}

function play(n) {
    // if (string == "attack") {
        // webSocket.send(JSON.stringify({command: "request", card: "dodge", amount: 1}))
        // webSocket.send(JSON.stringify({play: n}))
    webSocket.send(n)


    // }
    // return true
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
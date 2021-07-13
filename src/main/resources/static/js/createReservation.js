// Selecting HTML elements
var dateAndTime;
var guestFirstName;
var guestLastName;
var guestRoomNo;
var desiredResTable;

$("#reservationForm").submit(function (event) {
    event.preventDefault();
    desiredResTable = $("select[name=selectTable] option")
        .filter(":selected")
        .val();
    dateAndTime == $("#dateAndCheck").val();
    guestFirstName = $("#inputName").val();
    guestLastName = $("#inputLastname").val();
    guestRoomNo = $("#inputRoomNo").val();

    var reservationJsObject = {
        reservationDate: dateAndTime,
        guest: {
            firstName: guestFirstName,
            lastName: guestLastName,
        },
        table: {
            id: parseInt(desiredResTable),
        },
    };

    var reservationJSON = JSON.stringify(reservationJsObject);
    console.log(reservationJSON);
    $.ajax({
        type: "post",
        url: "http://localhost:8080/api/createNewReservation",
        data: reservationJSON,
        dataType: "application/json",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
    });
});

$("#dateCheckForm").submit(function (event) {
    //alert("Handler for .submit() called.");
    event.preventDefault();
    dateAndTime = $("#dateAndCheck").val();
    $.ajax({
        url: "http://localhost:8080/api/tables",
        headers: { Accept: "application/json" },
        type: "GET" /* or type:"GET" or type:"PUT" */,
        dataType: "json",
        data: {},
        success: function (data) {
            console.log(data);

            let html;
            data.forEach((element) => {
                html += `<option value=${element.id}>Table No: ${element.id}, Size: ${element.numberOfChairs} chairs, Location: ${element.floor}. floor</option>`;
            });

            $("#selectTable").append(html);
        },
        error: function () {
            console.log("error");
        },
    });
});

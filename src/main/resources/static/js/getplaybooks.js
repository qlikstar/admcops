var playbooks = function () {
    var serverdata;
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "deployment/playbooks",
        'dataType': "json",
        'success': function (data) {
            serverdata = data
        }
    });
    return serverdata;
}();


$(document).ready(function () {
        var json = playbooks;
        var tr;
        for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].playBookName + "</td>");
            tr.append("<td>" + json[i].playBookPermission + "</td>");
            tr.append("<td>" + json[i].playBookOwner + "</td>");
            tr.append("<td>" + json[i].playBookSize + "</td>");
            tr.append("<td>" + json[i].playbookLstModifiedTime + "</td>");
            tr.append("<td><button class=" + '"btn btn-primary"' + "> Run this playbook</button></td>");
            tr.append("<td><button class=" + '"btn btn-warning"' + "> Download to Share </button></td>");

            $('#playbooks-table').append(tr);
        }
    });


 function getlogs () {
      $.ajax({
          'async': false,
          'type': "GET",
          'url': "/deployment/logs",
          'success': function (data) {
              $('#playbook-log').text(data);
          }
      });
  };



$(document).ready(function(){
    $("#playbook-button").click(function(){
        $.get("/deployment/demo",
        function(data,status){
            alert("Demo playbook has been triggered! ");
            window.setInterval(function(){
              /// call your function here
              getlogs();

            }, 3000);
        });
    });
});


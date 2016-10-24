var appinfo = function () {
    var appdata;
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "/domain/app",
        'dataType': "json",
        'success': function (data) {
            appdata = data
        }
    });
//    console.log(appdata);
    return appdata;
}();


$(document).ready(function () {
        var tr;
        for (var i = 0; i < appinfo.length; i++) {
            tr = $('<tr/>');
            tr.append("<td> <b> App Name : </b> " + appinfo[i].appName  + "-"+ appinfo[i].appVersion +
            "<p> <b> App Desc : </b>" + appinfo[i].appDesc  +
            "<p> <b> App Owner : </b>" + appinfo[i].appOwner +
            "</td>");


            if (appinfo[i].clouds.length > 0){
                var cloudtable = '<table class="table table-bordered" ><tbody>'; // <thead><tr> <th> Cloud Provider </th> <th> Zone </th> </tr> </thead>
                for(var j = 0; j < appinfo[i].clouds.length; j++){
                    cloudtable = cloudtable + '<tr><td><b>' + appinfo[i].clouds[j].cloudProvider + '<b></td> <td>'
                    + appinfo[i].clouds[j].availabilityZone + '</td>';

                    if (appinfo[i].clouds[j].controls.length > 0){

                        //var publicSubnetTable = '<td><table class="table table-bordered" ><thead><tr> <th> Public Subnet Address </th> </thead><tbody>';
                        for(var k = 0; k < appinfo[i].clouds[j].controls.length; k++){
                            //publicSubnetTable = publicSubnetTable + '<tr><td>' + appinfo[i].clouds[j].controls[k].ipAddress + '</td></tr>'
                            publicSubnetTable = '<td> <b> Public Subnet : </b>' + appinfo[i].clouds[j].controls[k].ipAddress +
                            '<p><p><b> SSH Key : </b>' + appinfo[i].clouds[j].controls[k].sshKey
                            + '</td>'

                            if ( appinfo[i].clouds[j].controls[k].instances.length > 0 ){
                                var privateSubnetTable = '<td><table class="table table-bordered" ><thead><tr> <th> Private Subnet </th> <th> Host Name </th> <th> Operating System </th> <th> SSH Key </th> </tr> </thead><tbody>';

                                for( var l = 0; l < appinfo[i].clouds[j].controls[k].instances.length; l++){
                                    privateSubnetTable = privateSubnetTable + '<tr><td>'
                                    + appinfo[i].clouds[j].controls[k].instances[l].ipAddress + '</td>'
                                    + '<td>' + appinfo[i].clouds[j].controls[k].instances[l].hostName + '</td>'
                                    + '<td>' + appinfo[i].clouds[j].controls[k].instances[l].osName + ' ' + appinfo[i].clouds[j].controls[k].instances[l].osVersion + '</td>'
                                    + '<td>' + appinfo[i].clouds[j].controls[k].instances[l].sshKey + '</td>'
                                    + '</tr>';
                                }
                                privateSubnetTable = privateSubnetTable + '</tbody> </table> </td>';
                                publicSubnetTable = publicSubnetTable + privateSubnetTable;

                            }


                        }
                        //publicSubnetTable = publicSubnetTable + '</tbody> </table> </td>';
                        cloudtable = cloudtable + publicSubnetTable;

                    }else{

                        cloudtable = cloudtable + '<td> No Public Subnets configured  </td>' ;

                    }

                    cloudtable = cloudtable +  '</tr>';
                }
                cloudtable = cloudtable + '</tbody> </table> </td>';
                tr.append(cloudtable);
            }else{

                tr.append('<td>No Cloud Zones have been configured </td>');

            }

            $('#app-info-div').append(tr);
        }
    });
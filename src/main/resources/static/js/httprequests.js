
var serieshttp1 = function () {
    var series = new Array();
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "/monitor/http_requests_total",
        'dataType': "json",
        'success': function (data) {
           var input = new Array();

            for (i = 0; i < data.data.result.length; i++) {
                subinput = data.data.result[i];
                input.push(subinput.metric.job);
                var dataset = subinput.values;
                var newDataSet = new Array();
                for (j = 0; j < dataset.length; j++){
                    var formattedData = new Array();
                    formattedData.push(dataset[j][0] * 1000);
                    formattedData.push(parseInt(dataset[j][1]));
                    newDataSet.push(formattedData);
                }

                subseries = {"name" : subinput.metric.job + "." + subinput.metric.handler , "data" : newDataSet };
                series.push(subseries);
            }
//            console.log(series);
        }
    });
    return series;
}();

$(function () {
    $('#httprequests-chart').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'HTTP Requests Stats from Prometheus API'
        },
        subtitle: {
            text: 'Displays the number of get/put/post/delete requests received'
        },
        xAxis: {
            type: 'timestamp',
            title: {
                text: 'Time - server-name.handler-name'
            },
            labels: {
                format: '{value:%H:%M:%S}',
                rotation: 45,
                align: 'left'
            },
        },
        yAxis: {
            title: {
                text: 'Nos. of requests'
            },
            min: 0
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br>',
            pointFormat: '{point.x:%H:%M:%S}: {point.y}'
        },

//        legend: {
//            enabled: false
//        },
        plotOptions: {
            spline: {
                marker: {
                    enabled: true
                }
            }
        },

        series:serieshttp1
    });
});




var seriesmemory1 = function () {
    var series = new Array();
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "/monitor/node_memory_MemAvailable",
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
                    formattedData.push(parseInt(dataset[j][1]) / 1024);
                    newDataSet.push(formattedData);
                }

                subseries = {"name" : subinput.metric.job , "data" : newDataSet };
                series.push(subseries);
            }
            console.log(series);
        }
    });
    return series;
}();

$(function () {
    $('#availablememory-chart').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Available Memory on the nodes from Prometheus API'
        },
        subtitle: {
            text: 'Displays the available memory in respective nodes'
        },
        xAxis: {
            type: 'timestamp',
            title: {
                text: 'Time '
            },
            labels: {
                format: '{value:%H:%M:%S}',
                rotation: 45,
                align: 'left'
            },
        },
        yAxis: {
            title: {
                text: 'Available memory'
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

        series:seriesmemory1
    });
});



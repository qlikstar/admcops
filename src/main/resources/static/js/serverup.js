

var seriesServerUp = function () {
    var series = new Array();
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "/monitor/up",
        'dataType': "json",
        'success': function (data) {
           var input = new Array();

            for (i = 0; i < data.data.result.length; i++) {
                subinput = data.data.result[i];
                input.push(subinput.metric.job);
                var dataset =subinput.values;
                var newDataSet = new Array();
                for (j = 0; j < dataset.length; j++){
                    var formattedData = new Array();
                    formattedData.push(dataset[j][0] * 1000);
                    formattedData.push(parseInt(dataset[j][1]));
                    newDataSet.push(formattedData);
                }

                subseries = {"name" : subinput.metric.job , "data" : newDataSet };
                series.push(subseries);
            }
//            console.log(JSON.stringify(series));
//            console.log(series);
        }
    });
    return series;
}();

$(function () {
    $('#serverup-chart').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Server Up/Down Statistics from Prometheus API'
        },
        subtitle: {
            text: 'UP: 1 , DOWN: 0'
        },
        xAxis: {
            type: 'timestamp',
            title: {
                text: 'Time'
            },
            labels: {
                format: '{value:%H:%M:%S}',
                rotation: 45,
                align: 'left'
            },
        },
        yAxis: {
            title: {
                text: 'Server up/down'
            },
            min: 0, max:1
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br>',
            pointFormat: '{point.x:%H:%M:%S}: {point.y}'
        },

        plotOptions: {
            spline: {
                marker: {
                    enabled: true
                }
            }
        },

        series:seriesServerUp
    });
});



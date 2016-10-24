

var seriesRoutines = function () {
    var series = new Array();
    $.ajax({
        'async': false,
        'type': "GET",
        'url': "/monitor/go_goroutines",
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

$(function goroutinesRefresh() {
    $('#goroutines-chart').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Routines Statistics from Prometheus API'
        },
        subtitle: {
            text: 'Routine is a lightweight thread managed by the runtime environment'
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
                text: 'Nos of objects'
            },
            min: 0
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

        series:seriesRoutines
    });
});


window.setInterval(function(){
    goroutinesRefresh();

}, 3000);
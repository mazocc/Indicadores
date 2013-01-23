function rendenizarGrafico(json, container) {
    var chart;
    var mostraDecimais = json.eixoY.formato == 'Inteiro';
    var cats = new Array();
    var series = new Array();
    for (x in json.eixoX.categorias) {
        cats.push(json.eixoX.categorias[x].descricao);
    }

    for (x in json.series) {
        var obj = {
            name: json.series[x].nome,
            data: json.series[x].valores
        }
        series.push(obj);
    }


    chart = new Highcharts.Chart({
        chart: {
            renderTo: container,
            type: json.tipoGrafico
        },
        title: {
            text: json.titulo.titulo
        },
        xAxis: {
            categories: cats,
            labels: {
                rotation: -45,
                align: 'right',
                fontFamily: 'Consolas'
            }
        },
        yAxis: {
            allowDecimals: true,
            title: {
                text: json.eixoY.titulo.titulo
            },
            labels: {
                formatter: function () {
                    return formataValor(this.value, json.eixoY.formato);
                }
            }
        },
        tooltip: {
            formatter: function () {
                return this.x + "<br><strong style=\"color:" + this.series.color + "\">" + this.series.name + "</strong>:<b>" + formataValor(this.y, json.eixoY.formato);
                +"</b>";
            }
        },
        series: series
    }, function (chart) {
        if (json.ordem == 'Crescente') {
            chart.renderer.image('/public/images/seta-para-cima-verde.png', 0, chart.plotTop, 32, 32).add();
            chart.renderer.image('/public/images/seta-para-baixo-vermelha.png', 0, chart.plotHeight, 32, 32).add();
        } else {
            chart.renderer.image('/public/images/seta-para-cima-vermelha.png', 0, chart.plotTop, 32, 32).add();
            chart.renderer.image('/public/images/seta-para-baixo-verde.png', 0, chart.plotHeight, 32, 32).add();
        }
    });


    return chart;
}

function formataValor(valor, formato) {
    if (formato == "Inteiro") return valor.toFixed(0);
    else if (formato == "Numerico") return valor.toFixed(2);
    else if (formato == "Percentual") return valor.toFixed(2) + "%";
    else if (formato == "Monetario") return "R$ " + valor.toFixed(2);
    else return valor;
}
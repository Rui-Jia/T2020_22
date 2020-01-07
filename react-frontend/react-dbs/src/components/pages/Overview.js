import React, { Component } from 'react';
import '../../App.css';
import Axios from 'axios';
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";
import am4themes_material from "@amcharts/amcharts4/themes/material";

am4core.useTheme(am4themes_animated);
am4core.useTheme(am4themes_material);

export default class Overview extends Component {
    componentDidMount() {
        //XY chart
        let xyChart = am4core.create("xychartdiv", am4charts.XYChart);

        xyChart.paddingRight = 20;

        //Data for xyChart (Replace with actual data)
        let data = [];
        let visits = 10;
        for (let i = 1; i < 366; i++) {
            visits += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
            data.push({ date: new Date(2018, 0, i), name: "name" + i, value: visits });
        }

        xyChart.data = data;

        //Axis and Line rendering
        let dateAxis = xyChart.xAxes.push(new am4charts.DateAxis());
        dateAxis.renderer.grid.template.location = 0;

        let valueAxis = xyChart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.tooltip.disabled = true;
        valueAxis.renderer.minWidth = 35;

        let series = xyChart.series.push(new am4charts.LineSeries());
        series.dataFields.dateX = "date";
        series.dataFields.valueY = "value";

        series.tooltipText = "{valueY.value}";
        xyChart.cursor = new am4charts.XYCursor();

        let scrollbarX = new am4charts.XYChartScrollbar();
        scrollbarX.series.push(series);
        xyChart.scrollbarX = scrollbarX;

        this.xyChart = xyChart;

        //Pi chart 
        let piChart = am4core.create("pichartdiv", am4charts.PieChart)

        //Data for piChart (Replace with actual data)
        piChart.data = [{
            "country": "Lithuania",
            "litres": 501.9
        }, {
            "country": "Czech Republic",
            "litres": 301.9
        }, {
            "country": "Ireland",
            "litres": 201.1
        }, {
            "country": "Germany",
            "litres": 165.8
        }];

        // Add and configure Series
        var pieSeries = piChart.series.push(new am4charts.PieSeries());
        pieSeries.dataFields.value = "litres";
        pieSeries.dataFields.category = "country";

        // Let's cut a hole in our Pie chart the size of 40% the radius
        piChart.innerRadius = am4core.percent(40);

        // Disable ticks and labels
        pieSeries.labels.template.disabled = true;
        pieSeries.ticks.template.disabled = true;

        // Disable tooltips
        pieSeries.slices.template.tooltipText = "";

        // Add a legend
        piChart.legend = new am4charts.Legend();
        piChart.legend.position = "right"
    }

    componentWillUnmount() {
        if (this.chart) {
            this.chart.dispose();
        }
        if (this.chart2) {
            this.chart2.dispose();
        }
    }

    render() {
        return (
            //Dashboard view
            <div id="Overview">
                <div id="chartContainer" style={{ display: "inline-block" }}>
                    <div id="xychartdiv" style={{ width: "65%", height: "500px", float: "left", display: "inline" }}></div>
                    <div id="pichartdiv" style={{ width: "35%", height: "250px", float: "right", display: "inline" }}></div>
                    <p></p>
                </div>
                <p style={chartContainerStyle}></p>
                <div id="productRecommendations" style={{ display: "inline-block" }}>
                    <div id="recommendationOne" style={{width: "30%", display:"inline"}}>

                    </div>
                    <div id="recommendationTwo" style={{width: "30%", display:"inline"}}>

                    </div>
                    <div id="recommendationThree" style={{width: "30%", display:"inline"}}>

                    </div>
                </div>
            </div>
        );
    }
}

const chartContainerStyle = {
    borderBottom: '2px #999966 solid',
    margin: '2px 35px',
}


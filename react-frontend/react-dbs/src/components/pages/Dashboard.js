import React, { Component } from 'react';
import '../../App.css';
import Axios from 'axios';
import dbsEssoCard from "../../../src/dbs-esso-card.png";
import dbsAltitudeCard from "../../../src/dbs-altitude-card.png"
import dbsEverydayCard from "../../../src/dbs-everyday-card.png"
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";
import am4themes_material from "@amcharts/amcharts4/themes/material";
import SimpleTable from '../Table';

am4core.useTheme(am4themes_animated);
am4core.useTheme(am4themes_material);

export default class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tableHead: ['Head', 'Head2', 'Head3', 'Head4'],
            tableData: [
                ['1', '2', '3', '4'],
                ['a', 'b', 'c', 'd'],
                ['1', '2', '3', '456\n789'],
                ['a', 'b', 'c', 'd'],
            ],
            data: [],
        }
    }

    retrieveData = () => {
        Axios.get('127.0.0.1/8080/balance').then(res => this.setState({ data: res.data }))
    }

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
        const state = this.state;
        return (
            //Dashboard view
            <div id="Dashboard" style={{ background: " " }}>
                <div id="chartContainer" style={{ display: "inline-block" }}>
                    <div id="xychartdiv" style={{ width: "1300px", height: "500px", float: "left", display: "inline-block" }}></div>
                    <div id="pichartdiv" style={{ width: "600px", height: "200px", float: "right", display: "inline-block" }}></div>
                    <div id="accountDetails" style={detailStyle}>
                        <SimpleTable />
                    </div>
                </div>
                <p style={chartContainerStyle}></p>
                <div id="productRecommendations">
                    <div style={recommendationStyle}>
                        <h3 style={{ textAlign: "center", display: "inline-block" }}>test</h3>
                        <div id="recommendationOne" style={itemStyle}>
                            <div style={{ float: "left", backgroundColor: "grey" }}>
                                <img src={dbsEssoCard} alt="dbsEssoCard" style={{ width: '50%' }} />
                                <p>DBS Esso Card</p>
                            </div>
                        </div>
                    </div>
                    <div style={recommendationStyle}>
                        <h3 style={{ textAlign: "center", display: "inline-block" }}>test</h3>
                        <div id="recommendationTwo" style={itemStyle}>
                            <div style={{ float: "left", backgroundColor: "grey" }}>
                                <img src={dbsAltitudeCard} alt="dbsAltitudeCard" style={{ width: "50%" }} />
                                <p>DBS Altitude Card</p>
                            </div>
                        </div>
                    </div>
                    <div style={recommendationStyle}>
                        <h3 style={{ textAlign: "center", display: "inline-block" }}>test</h3>
                        <div id="recommendationThree" style={itemStyle}>
                            <div style={{ float: "left", backgroundColor: "grey" }}>
                                <img src={dbsEverydayCard} alt="dbsEverydayCard" style={{ width: "50%" }} />
                                <p>DBS Everyday Card</p>
                            </div>
                        </div>
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

const recommendationStyle = {
    width: '400px',
    display: 'inline-block',
    margin: '100px',
}

const itemStyle = {
    borderStyle: 'solid',
    borderWidth: '1px',
    width: '400px',
    display: 'inline-block',
    margin: '100px',
}

const detailStyle = {
    width: "600px",
    height: "200px",
    float: "right",
    display: "inline-block",
}


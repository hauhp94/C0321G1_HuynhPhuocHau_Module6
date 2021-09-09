import {Component, OnInit} from '@angular/core';
import {Chart, ChartType, registerables } from "chart.js";

Chart.register(...registerables);

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {
  labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
  ];
  data = {
    labels: this.labels,
    datasets: [{
      label: 'My First dataset',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: [0, 10, 5, 2, 20, 30, 45],
    }]
  };
  config = {
    type: 'bar',
    data: this.data,
    options: {}
  };



  constructor() {
  }

  ngOnInit(): void {
    const myChart = new Chart(
      'myChart',
      {
        type: 'bar',
        data: this.data,
        options: {}
      }
    );
  }

}

const motivationlist = /*[[${motivationlist}]]*/"motivationlist";
const rate = motivationlist.map(x=>x.rate);

let titleArray = [];
const title =motivationlist.map(x=>x.title);

for(var i = 0; i < title.length; i++){
  titleArray.push(title[i]);
}

let rateArray = [];
for(var i = 0; i < rate.length; i++){
  rateArray.push(rate[i]);
}
/*<![CDATA[*/
var ctx = document.getElementById("LineChart").getContext('2d');
var LineChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: titleArray,
      datasets: [
          {
            label: "満足度",
            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(242, 87, 87, 0.9)',
              'rgba(153,242,87,0.9)',
              'rgba(87, 138, 242, 0.9)',
              'rgba(242,231,87,0.9)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgba(242, 87, 87, 0.9)',
              'rgba(87, 138, 242, 0.9)',
              'rgba(242,231,87,0.9)'
            ],
            borderWidth: 1,
            lineTension: 0,
            fill: false,
            data: rateArray,
          },
      ]
    },
    options: {
      responsive: true,
      scales: {
        yAxes: [
          {
            ticks: {
              min: 0
            }
          }
        ]
      }
    },
});

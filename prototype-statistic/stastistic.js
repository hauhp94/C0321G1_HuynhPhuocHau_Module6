
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx)
window.onload = statisticByComputer();

function statisticBy(type) {
    var value = type.value;
    value === "computer" ? statisticByComputer() : (value === 'month' ? statisticByMonth() : statisticByAccount());
}

function statisticByComputer() {
    document.getElementById("statisticTimeTr").style.display = "none";
    myChart.destroy();
    myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            responsive: true,
            labels: ['A1', 'A2', 'A3', 'A4', 'A5', 'A6'],
            datasets: [{
                label: 'hour',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: ['#FFF447'],
                borderColor: ['#FFF447'],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Hour",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                        padding: {top: 30, left: 0, right: 0, bottom: 0}
                    }
                },
                x: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Computer ID",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                    }
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Statistic by computer chart',
                    position: 'top',
                    color: '#3EB595',
                    font: {
                        family: 'Averta',
                        size: 30,
                        style: 'normal',
                        lineHeight: 1.0
                    }
                }
            }
        }
    });

}

function statisticByMonth() {
    document.getElementById("statisticTimeTr").style.display = "none";
    myChart.destroy();
    myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            responsive: true,
            labels: ['January', 'February', 'March', 'April', 'May', 'June'],
            datasets: [{
                label: 'Computer',
                data: [500000, 275000, 50000, 450000, 95000, 70000],
                backgroundColor: ['#FFF447'],
                borderColor: ['#FFF447'],
                borderWidth: 1
            },
                {
                    label: 'Service',
                    data: [100000, 120000, 30000, 60000, 75000, 200000],
                    backgroundColor: ['#3EB595'],
                    borderColor: ['#3EB595'],
                    borderWidth: 1
                },
                {
                    label: 'Total',
                    data: [600000, 395000, 80000, 510000, 170000, 270000],
                    backgroundColor: ['#696969'],
                    borderColor: ['#696969'],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Money (VND)",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                        padding: {top: 30, left: 0, right: 0, bottom: 0}
                    }
                },
                x: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Month",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                    }
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Statistic by month chart',
                    position: 'top',
                    color: '#3EB595',
                    font: {
                        family: 'Averta',
                        size: 30,
                        style: 'normal',
                        lineHeight: 1.0
                    }
                }
            }
        }
    });
}

function statisticByAccount() {
    document.getElementById("statisticTimeTr").style.display = "table-row";
    myChart.destroy();
    myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            responsive: true,
            labels: ['VipAbc', 'AnhHungNup', 'Metar95', 'HotDrink99', 'DungTran', 'NguyenLam'],
            datasets: [{
                label: 'hour',
                data: [45, 44, 77, 26, 123, 49],
                backgroundColor: ['#FFF447'],
                borderColor: ['#FFF447'],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Hour",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                        padding: {top: 30, left: 0, right: 0, bottom: 0}
                    }
                },
                x: {
                    beginAtZero: true,
                    display: true,
                    title: {
                        display: true,
                        text: "Account",
                        color: '#3EB595',
                        font: {
                            family: 'Averta',
                            size: 15,
                            style: 'normal',
                            lineHeight: 1.0
                        },
                    }
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Statistic by account chart',
                    position: 'top',
                    color: '#3EB595',
                    font: {
                        family: 'Averta',
                        size: 30,
                        style: 'normal',
                        lineHeight: 1.0
                    }
                }
            }
        }
    });
}

import * as React from 'react';
import Stack from '@mui/material/Stack';
import { BarChart } from '@mui/x-charts/BarChart';

const AccommodationsBarChart = ({ stats }) => {

    const categories = Object.keys(stats); // ["HOTEL", "APARTMENT"]
    const dataValues = Object.values(stats); // [2, 1]

    const barChartsParams = {
        xAxis: [{ data: categories }],
        series: [
            { data: dataValues, label: 'Number of accommodations', color: 'green' }
        ],
        margin: { top: 20, right: 10 },
        height: 300,
        hideLegend: false,
    };

    return (
        <Stack direction="column" sx={{ width: '100%', maxWidth: 600 }}>
            <BarChart {...barChartsParams} slotProps={{ tooltip: { trigger: 'axis' } }} />
        </Stack>
    );
};

export default AccommodationsBarChart;

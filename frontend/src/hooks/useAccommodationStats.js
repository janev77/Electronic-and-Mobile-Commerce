import React, { useEffect, useState } from 'react';
import accommodationRepository from "../repository/accommodationRepository.js"; // or accommodationRepository

const useAccommodationStats = () => {
    const [stats, setStats] = useState([]);

    useEffect(() => {
        const fetchStats = async () => {
            try {
                const response = await accommodationRepository.statistic();
                setStats(response.data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchStats();
    }, []);

    return { stats };
};

export default useAccommodationStats;
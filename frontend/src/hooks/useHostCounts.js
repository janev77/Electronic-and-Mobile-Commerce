import React, {useEffect, useState} from 'react';
import countryRepository from "../repository/countryRepository.js";

const UseHostCounts = () => {

    const [hostCounts, setHostCounts] = useState([]);

    useEffect(() => {
        countryRepository
            .byCountry()
            .then((response) => setHostCounts(response.data))
            .catch((error) => console.log(error));
    }, []);
    return hostCounts
};

export default UseHostCounts;
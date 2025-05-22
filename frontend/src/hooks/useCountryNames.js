import React, {useEffect, useState} from 'react';
import countryRepository from "../repository/countryRepository.js";

const UseCountryNames = () => {

    const [countryNames, setCountryNames] = useState([]);

    useEffect(() => {
        countryRepository
            .findAll()
            .then((response) => setCountryNames(response.data))
            .catch((error) => console.log(error));
    }, []);
    return countryNames
};

export default UseCountryNames;
import React, {useEffect, useState} from 'react';
import hostRepository from "../repository/hostRepository.js";

const UseHostCounts = () => {

    const [accommodationCounts, setAccommodationCounts] = useState([]);

    useEffect(() => {
        hostRepository
            .accommodationsByHost()
            .then((response) => setAccommodationCounts(response.data))
            .catch((error) => console.log(error));
    }, []);
    return accommodationCounts
};

export default UseHostCounts;
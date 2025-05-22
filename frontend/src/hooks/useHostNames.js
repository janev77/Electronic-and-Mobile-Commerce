import React, {useEffect, useState} from 'react';
import hostRepository from "../repository/hostRepository.js";

const UseHostNames = () => {

    const [hostNames, setHostNames] = useState([]);

    useEffect(() => {
        hostRepository
            .findAll()
            .then((response) => setHostNames(response.data))
            .catch((error) => console.log(error));
    }, []);
    return hostNames
};

export default UseHostNames;
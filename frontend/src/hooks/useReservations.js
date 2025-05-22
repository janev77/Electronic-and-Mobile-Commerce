import {useCallback, useEffect, useState} from 'react'
import reservationRepository from "../repository/reservationRepository.js";

const initialState = {
    "reservations": [],
    "loading": true,
};

const useReservations = () => {
    const [state, setState] = useState(initialState);

    const fetchReservations = useCallback(() => {
        reservationRepository
            .findAll()
            .then((response) => {
                setState({
                    "reservations": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);


    useEffect(() => {
        fetchReservations()
    }, [fetchReservations]);


    return { ...state};
};

export default useReservations;
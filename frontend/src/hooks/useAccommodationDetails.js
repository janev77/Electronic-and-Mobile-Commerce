import {useEffect, useState} from "react";
import accommodationRepository from "../repository/accommodationRepository.js";

const useAccommodationDetails = (id) => {
    const [state, setState] = useState({
        "accommodation": null,
    });

    useEffect(() => {
        accommodationRepository
            .findById(id)
            .then((response) => {
                setState(prevState => ({...prevState, "accommodation": response.data}));
            })
            .catch((error) => console.log(error));
    }, [id]);

    return state;
};

export default useAccommodationDetails;
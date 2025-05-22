import {useEffect, useState} from "react";
import hostRepository from "../repository/hostRepository.js";

const useHostDetails = (id) => {
    const [state, setState] = useState({
        "host": null,
    });

    useEffect(() => {
        hostRepository
            .findById(id)
            .then((response) => {
                setState(prevState => ({...prevState, "host": response.data}));
            })
            .catch((error) => console.log(error));
    }, [id]);

    return state;
};

export default useHostDetails;
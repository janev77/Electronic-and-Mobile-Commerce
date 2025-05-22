import {useEffect, useState} from "react";
import accommodationRepository from "../repository/accommodationRepository.js";

const useAccommodationFlow = (id) => {
    const [accommodationFlow, setAccommodationFlow] = useState(null);

    useEffect(() => {
        if (!id) return;

        accommodationRepository
            .accommodationFlow(id)
            .then(response => {
                setAccommodationFlow(response.data);
            })
            .catch(error => {
                console.error("Failed to fetch accommodation details:", error);
            });
    }, [id]);

    return {accommodationFlow};
};

export default useAccommodationFlow;

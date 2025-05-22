import React, {useEffect, useState} from 'react';
import categoryRepository from "../repository/categoryRepository.js";

const useCategories = () => {

    const [categoryName, setCategoryName] = useState([]);

    useEffect(() => {
        categoryRepository
            .findAll()
            .then((response) => {
                // console.log("Fetched categories:", response.data);
                setCategoryName(response.data);
            })
            .catch((error) => console.log("Error fetching categories:", error));
    }, []);

    return categoryName
};

export default useCategories;
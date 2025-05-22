import axiosInstance from "../axios/axios.js"

const countryRepository = {
    findAll: async () => {
        return await axiosInstance.get("/country");
    },

    findById: async (id) => {
        return await axiosInstance.get(`/country/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post(`/country/add`, data);
    },

    edit: async (id, data) => {
        return await axiosInstance.put(`/country/edit/${id}`, data);
    },

    delete: async (id) => {
        return await axiosInstance.delete(`/country/delete/${id}`);
    },


    byCountry: async () => {
        return await axiosInstance.get(`/host/by-country`);
    },

    byCountryId: async (id) => {
        return await axiosInstance.get(`/host/by-country/${id}`);
    },

    names: async () => {
        return await axiosInstance.get(`/host/names`);
    },
};

export default countryRepository;
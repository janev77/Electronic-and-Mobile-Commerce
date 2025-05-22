import axiosInstance from "../axios/axios.js"

const reservationRepository = {
    findAll: async () => {
        return await axiosInstance.get("/reservation");
    },

    findById: async (id) => {
        return await axiosInstance.get(`/reservation/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post(`/reservation/add`, data);
    },
    // edit: async (id, data) => {
    //     return await axiosInstance.put(`/reservation/edit/${id}`, data);
    // },

};

export default reservationRepository;
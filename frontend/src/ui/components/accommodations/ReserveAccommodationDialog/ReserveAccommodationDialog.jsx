import React, {useState} from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle, FormControl, InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";

const initialFormData = {
    "code": "",
    "start_date": "",
    "end_date": "",
    "numOfGuests": "",
    "price": "",
    "accommodationId": ""
};

const ReserveAccommodationDialog = ({open, onClose, onReserve}) => {

    const [formData, setFormData] = useState(initialFormData);

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onReserve(formData);
        setFormData(initialFormData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Reservation</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Code"
                    name="code"
                    value={formData.code}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Start date"
                    name="start_date"
                    value={formData.start_date}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="End date"
                    name="end_date"
                    value={formData.end_date}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="num of guests"
                    name="numOfGuests"
                    value={formData.numOfGuests}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Price"
                    name="price"
                    value={formData.price}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="AccommodationId"
                    name="accommodationId"
                    value={formData.accommodationId}
                    onChange={handleChange}
                    fullWidth
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="primary">Reserve</Button>
            </DialogActions>
        </Dialog>
    );
};

export default ReserveAccommodationDialog;
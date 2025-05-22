import React from 'react';
import {useNavigate, useParams} from "react-router";
import {
    Box,
    Button,
    Chip,
    CircularProgress,
    Grid,
    Typography,
    Paper,
    Avatar,
    Stack,
    Rating,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack,
    Category,
    Factory,
    Star,
    ShoppingCart,
    FavoriteBorder,
    Share
} from "@mui/icons-material";
import useAccommodationFlow from "../../../../hooks/useAccommodationFlow.js";


const AccommodationDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const {accommodationFlow} = useAccommodationFlow(id)

    if (!accommodationFlow) {
        return (
            <Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh'}}>
                <CircularProgress/>
            </Box>
        );
    }

    return (
        <Box>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/accommodations");
                    }}
                >
                    Countries
                </Link>
                <Typography color="text.primary">{accommodationFlow.name}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Grid container spacing={1}>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="h3" gutterBottom sx={{fontWeight: 600}}>
                                {accommodationFlow.name}
                            </Typography>
                        </Box>
                        <Box sx={{mb: 3}}>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Category: {accommodationFlow.category}
                            </Typography>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Number of rooms: {accommodationFlow.numRooms}
                            </Typography>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Host name: {accommodationFlow.host.name} {accommodationFlow.host.surname}
                            </Typography>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Country: {accommodationFlow.country.name}
                            </Typography>
                        </Box>
                        <Button
                            variant="outlined"
                            color="success"
                            startIcon={<ArrowBack/>}
                            onClick={() => navigate("/accommodations")}
                        >
                            Back to Countries
                        </Button>
                    </Grid>
                </Grid>
            </Paper>
        </Box>
    );
};

export default AccommodationDetails;
import React from 'react';
import {useNavigate, useParams} from "react-router";
import useHostDetails from "../../../../hooks/useHostDetails.js";
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
import useAccommodationCounts from "../../../../hooks/useAccommodationCounts.js";

const HostDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const {host} = useHostDetails(id);

    const accommodationCounts = useAccommodationCounts();
    const accommodationCount = accommodationCounts.find(entry => entry.hostId === Number(id))?.numAccommodations ?? 0;

    if (!host) {
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
                        navigate("/hosts");
                    }}
                >
                    Hosts
                </Link>
                <Typography color="text.primary">{host.name} {host.surname}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Grid container spacing={1}>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="h3" gutterBottom sx={{fontWeight: 600}}>
                                {host.name} {host.surname}
                            </Typography>
                        </Box>
                    </Grid>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Number of accommodations: {accommodationCount}
                            </Typography>
                        </Box>
                    </Grid>
                    <Button
                        variant="outlined"
                        color="success"
                        startIcon={<ArrowBack/>}
                        onClick={() => navigate("/hosts")}
                    >
                        Back to Hosts
                    </Button>
                </Grid>
            </Paper>
        </Box>
    );
};

export default HostDetails;
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Replace with your Spring Boot API URL

export const getUsers = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/api/users`);
        return response.data;
    } catch (error) {
        console.error('Error fetching users:', error);
        throw error;
    }
};

export const getUser = async (id) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/api/users/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching user:', error);
        throw error;
    }
};

export const createUser = async (user) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/api/users`, user);
        return response.data;
    } catch (error) {
        console.error('Error creating user:', error);
        throw error;
    }
};

export const updateUser = async (id, user) => {
    try {
        const response = await axios.put(`${API_BASE_URL}/api/users/${id}`, user);
        return response.data;
    } catch (error) {
        console.error('Error updating user:', error);
        throw error;
    }
};

export const deleteUser = async (id) => {
    try {
        await axios.delete(`${API_BASE_URL}/api/users/${id}`);
    } catch (error) {
        console.error('Error deleting user:', error);
        throw error;
    }
};

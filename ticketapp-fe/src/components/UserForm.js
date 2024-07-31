import React, { useState } from 'react';
import { createUser, updateUser } from '../services/apiService';

const UserForm = ({ userToEdit, onUserSaved }) => {
    const [name, setName] = useState(userToEdit ? userToEdit.name : '');
    const [email, setEmail] = useState(userToEdit ? userToEdit.email : '');

    const handleSubmit = async (event) => {
        event.preventDefault();
        const user = { name, email };
        try {
            if (userToEdit) {
                await updateUser(userToEdit.id, user);
            } else {
                await createUser(user);
            }
            onUserSaved();
        } catch (error) {
            console.error('Error saving user:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>{userToEdit ? 'Edit User' : 'Create User'}</h2>
            <div>
                <label>Name:</label>
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
            </div>
            <div>
                <label>Email:</label>
                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            </div>
            <button type="submit">{userToEdit ? 'Update' : 'Create'}</button>
        </form>
    );
};

export default UserForm;

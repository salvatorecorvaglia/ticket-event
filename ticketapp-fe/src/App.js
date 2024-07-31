import React, { useState } from 'react';
import UserList from './components/UserList';
import UserForm from './components/UserForm';

const App = () => {
    const [editingUser, setEditingUser] = useState(null);
    const [refresh, setRefresh] = useState(false);

    const handleUserSaved = () => {
        setRefresh(!refresh);
        setEditingUser(null);
    };

    return (
        <div>
            <h1>Ticket App</h1>
            <UserForm userToEdit={editingUser} onUserSaved={handleUserSaved} />
            <UserList key={refresh} />
            {/* Add more components or routes if needed */}
        </div>
    );
};

export default App;

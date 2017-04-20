import React from 'react';
import {Navbar} from 'react-bootstrap';

class Header extends React.Component {
    render() {
        return (
            <Navbar>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#"> Movie Catalog </a>
                    </Navbar.Brand>
               </Navbar.Header>
            </Navbar>
        );
    }
}

export default Header;
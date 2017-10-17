<%@page import="Config.PathConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String navbar = (String) request.getAttribute("navbar"); 
%>


<section class="hero is-info is-small">
    <div class="hero-head">
        <header class="nav">
            <div class="container">
                <div class="nav-left">
                    <a class="nav-item">
                        <img src="images/bulma-type-white.png" alt="Logo">
                    </a>
                </div>
                <span class="nav-toggle">
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
                <div class="nav-right nav-menu">
                    <a class="nav-item is-active">
                        Account
                    </a>
                    <span class="nav-item">
                        <a class="button is-info is-inverted" href="<%= PathConfig.root %>auth/logout">
                            <span class="icon">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                            </span>
                            <span>Logout</span>
                        </a>
                    </span>
                </div>
            </div>
        </header>
    </div>

    <!-- Hero content: will be in the middle -->
    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title">
                PRJ321
            </h1>
            <h2 class="subtitle">
                QuyTa
            </h2>
        </div>
    </div>

    <!-- Hero footer: will stick at the bottom -->
    <div class="hero-foot">
        <nav class="tabs is-boxed is-fullwidth">
            <div class="container">
                <ul>
                    <li<% if (navbar.equals("home")) { %> class="is-active" <% } %>>
                        <a href="<%= PathConfig.root %>home">Home</a>
                    </li>
        
                    <li<% if (navbar.equals("user.list")) { %> class="is-active" <% } %>>
                        <a href="<%= PathConfig.root %>user/list">Users</a>
                    </li>
                    
                    <li<% if (navbar.equals("request.list")) { %> class="is-active" <% } %>>
                        <a href="<%= PathConfig.root %>request/list">Requests</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</section>

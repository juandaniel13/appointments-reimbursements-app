export interface Auth {
}

export interface AuthRequest {
    email:'';
    password:'';
}

export interface AuthResponse{
    token:string;
}

export interface AuthParams {
    body: AuthRequest
}

export interface AuthError{
    code:number;
    message:string
}
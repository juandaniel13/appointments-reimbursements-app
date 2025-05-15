export interface Patient {
}

export interface PatientResponse{
    id: number;
    firstName: string;
    lastName: string | null;
    email: string;
}
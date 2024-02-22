import { BlogInfo } from "./BlogInfo";
import { UserRole } from "./UserRole";

export class User {
    public id: string | undefined;

    public username: string | undefined;

    public name: string | undefined;

    public surname: string | undefined;

    public email: string | undefined;

    public dateOfBirth: string = "";

    public gender: string | undefined;

    public role: UserRole = UserRole.ROLE_USER;

    public blogs: Array<BlogInfo> = [];
};
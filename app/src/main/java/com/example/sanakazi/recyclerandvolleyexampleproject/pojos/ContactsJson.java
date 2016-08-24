package com.example.sanakazi.recyclerandvolleyexampleproject.pojos;

/**
 * Created by SanaKazi on 8/23/2016.
 */
public class ContactsJson {
    private Contacts[] contacts;

    public Contacts[] getContacts ()
    {
        return contacts;
    }

    public void setContacts (Contacts[] contacts)
    {
        this.contacts = contacts;
    }

    @Override
    public String toString()
    {
        return "ContactsJson [contacts = "+contacts+"]";
    }

    public class Contacts
    {
        private String id;

        private Phone phone;

        private String address;

        private String email;

        private String name;

        private String gender;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public Phone getPhone ()
        {
            return phone;
        }

        public void setPhone (Phone phone)
        {
            this.phone = phone;
        }

        public String getAddress ()
        {
            return address;
        }

        public void setAddress (String address)
        {
            this.address = address;
        }

        public String getEmail ()
        {
            return email;
        }

        public void setEmail (String email)
        {
            this.email = email;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getGender ()
        {
            return gender;
        }

        public void setGender (String gender)
        {
            this.gender = gender;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", phone = "+phone+", address = "+address+", email = "+email+", name = "+name+", gender = "+gender+"]";
        }

        public class Phone
        {
            private String office;

            private String home;

            private String mobile;

            public String getOffice ()
            {
                return office;
            }

            public void setOffice (String office)
            {
                this.office = office;
            }

            public String getHome ()
            {
                return home;
            }

            public void setHome (String home)
            {
                this.home = home;
            }

            public String getMobile ()
            {
                return mobile;
            }

            public void setMobile (String mobile)
            {
                this.mobile = mobile;
            }

            @Override
            public String toString()
            {
                return "ClassPojo [office = "+office+", home = "+home+", mobile = "+mobile+"]";
            }
        }
    }
}
